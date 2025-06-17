package devcalc;

import devcalc.services.CalculatorService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class Main {
    public static void main(String[] args) {
        CalculatorService calculator = new CalculatorService();
        Javalin app = Javalin.create().start(7000);

        app.get("/add", ctx -> {
            try {
                int a = getQueryParamAsInt(ctx, "a");
                int b = getQueryParamAsInt(ctx, "b");
                int result = calculator.add(a, b);
                ctx.result("Resultado: " + String.valueOf(result) + "\n");
            } catch(IllegalArgumentException e) {
                ctx.status(400).result(e.getMessage());
            }
        });
        app.get("/subtract", ctx -> {
            try {
                int a = getQueryParamAsInt(ctx, "a");
                int b = getQueryParamAsInt(ctx, "b");
                int result = calculator.subtract(a, b);
                ctx.result("Resultado: " + String.valueOf(result) + "\n");
            } catch(IllegalArgumentException e) {
                ctx.status(400).result(e.getMessage());;
            }
        });
        app.get("/multiply", ctx -> {
           try {
               int a = getQueryParamAsInt(ctx, "a");
               int b = getQueryParamAsInt(ctx, "b");
               int result = calculator.multiply(a, b);
               ctx.result("Resultado: " + String.valueOf(result) + "\n");
           } catch (IllegalArgumentException e) {
               ctx.status(400).result(e.getMessage());
           }
        });
        app.get("/divide", ctx -> {
            int a = getQueryParamAsInt(ctx, "a");
            int b = getQueryParamAsInt(ctx, "b");
            try {
                int result = calculator.divide(a, b);
                ctx.result("Resultado: " + String.valueOf(result) + "\n");
            } catch (IllegalArgumentException e) {
                ctx.status(400).result(e.getMessage());
            }
        });
    }

    private static int getQueryParamAsInt(Context ctx, String paramName) {
        String param = ctx.queryParam(paramName);
        if (param == null) {
            throw new IllegalArgumentException("Parâmetro '" + paramName + "' é obrigatório\n");
        }
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Parâmetro '" + paramName + "' inválido\n");
        }
    }
}