<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verificar Múltiplos e Divisores</title>
    <link rel="icon" type="image/x-icon" href="http://www.rw-designer.com/icon-image/20362-128x128x32.png" />
    <link rel="stylesheet" href="styles.css" />

</head>
<body>
    <div class="mudaessacor">
        <h1>Verificar Relação Numérica</h1>

        <form action="VerificaServlet" method="post">
            <input type="number" id="numeroA" name="numeroA" required min="1" placeholder="Número A" />
            
            <input type="number" id="numeroB" name="numeroB" required min="1" placeholder="Número B" />
            
            <select name="tipoVerificacao" id="tipoVerificacao">
                <option value="multiplo">A é múltiplo de B</option>
                <option value="divisor">A é divisor de B</option>
            </select>
            
            <input type="submit" value="Verificar Relação" />
        </form>

        <hr />

        <%
            String resultado = (String) request.getAttribute("resultadoVerificacao");
            if (resultado != null) {
                String classe = resultado.contains("é") ? "verde" : "vermelho";
                out.println("<div class='resultado " + classe + "'>" + resultado + "</div>");
            }
        %>
    </div>
</body>
</html>