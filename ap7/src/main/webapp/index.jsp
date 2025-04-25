<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Multiplos e Divisores </title>
    <link rel="icon" type="image/x-icon" href="http://www.rw-designer.com/icon-image/20362-128x128x32.png" />
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
    <div class="mudaessacor">
        <h1>Multiplos e Divisores</h1>

        <!-- Formulário para os números e operação -->
        <form action="ModificaServlet" method="post">
            <label for="numero1">Número 1:</label>
            <input type="number" id="numero1" name="numero1" required /> <br />

            <label for="numero2">Número 2:</label>
            <input type="number" id="numero2" name="numero2" required /> <br />

            <label for="operacao">Operação:</label>
            <select name="operacao" id="operacao">
                <option value="multiplicacao">Multiplicação</option>
                <option value="divisao">Divisão</option>
            </select> <br />

            <input type="submit" value="Calcular" />
        </form>

        <hr />

        <!-- Exibindo o resultado da calculadora -->
        <%
            String resultado = (String) request.getAttribute("resultadoCalculadora");
            if (resultado != null) {
                out.println("<h3>" + resultado + "</h3>");
            }
        %>
    </div>
</body>
</html>
