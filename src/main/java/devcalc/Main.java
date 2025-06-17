package devcalc;

import devcalc.services.CalculatorService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public final class Main {

    private Main() {
        throw new UnsupportedOperationException("Classe utilitária");
    }

    /**
     * Porta onde o servidor Javalin irá escutar.
     */
    private static final int PORT = 7000;
    /**
     * Código de status HTTP para requisições inválidas.
     */
    private static final int BAD_REQUEST = 400;

    /**
     * Inicia o servidor Javalin.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(final String[] args) {
        CalculatorService calculator = new CalculatorService();
        Javalin app = Javalin.create().start(PORT);

        app.get("/add", ctx -> {
            try {
                int a = getQueryParamAsInt(ctx, "a");
                int b = getQueryParamAsInt(ctx, "b");
                int result = calculator.add(a, b);
                ctx.result("Resultado: " + result + "\n");
            } catch (IllegalArgumentException e) {
                ctx.status(BAD_REQUEST).result(e.getMessage());
            }
        });

        app.get("/subtract", ctx -> {
            try {
                int a = getQueryParamAsInt(ctx, "a");
                int b = getQueryParamAsInt(ctx, "b");
                int result = calculator.subtract(a, b);
                ctx.result("Resultado: " + result + "\n");
            } catch (IllegalArgumentException e) {
                ctx.status(BAD_REQUEST).result(e.getMessage());
            }
        });

        app.get("/multiply", ctx -> {
            try {
                int a = getQueryParamAsInt(ctx, "a");
                int b = getQueryParamAsInt(ctx, "b");
                int result = calculator.multiply(a, b);
                ctx.result("Resultado: " + result + "\n");
            } catch (IllegalArgumentException e) {
                ctx.status(BAD_REQUEST).result(e.getMessage());
            }
        });

        app.get("/divide", ctx -> {
            int a = getQueryParamAsInt(ctx, "a");
            int b = getQueryParamAsInt(ctx, "b");
            try {
                int result = calculator.divide(a, b);
                ctx.result("Resultado: " + result + "\n");
            } catch (IllegalArgumentException e) {
                ctx.status(BAD_REQUEST).result(e.getMessage());
            }
        });
    }

    private static int getQueryParamAsInt(
            final Context ctx,
            final String paramName
    ) {
        String param = ctx.queryParam(paramName);
        if (param == null) {
            throw new IllegalArgumentException(
                    "Parâmetro '" + paramName + "' é obrigatório\n"
            );
        }

        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Parâmetro '" + paramName + "' inválido\n"
            );
        }
    }
}
