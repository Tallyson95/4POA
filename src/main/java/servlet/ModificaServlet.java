package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ModificaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Verificar qual formulário foi submetido
        if (request.getParameter("operacao") != null) {
            processarCalculadora(request, response);
        } else if (request.getParameter("tipoVerificacao") != null) {
            processarVerificacao(request, response);
        }
    }

    private void processarCalculadora(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obter números e operação da requisição
        double numero1 = 0, numero2 = 0;
        String operacao = request.getParameter("operacao");
        String resultadoCalculadora = "";

        try {
            numero1 = Double.parseDouble(request.getParameter("numero1"));
            numero2 = Double.parseDouble(request.getParameter("numero2"));

            // Realizando a operação escolhida
            if ("multiplicacao".equals(operacao)) {
                resultadoCalculadora = "Resultado da multiplicação: " + (numero1 * numero2);
            } else if ("divisao".equals(operacao)) {
                if (numero2 == 0) {
                    resultadoCalculadora = "Erro: Não é possível dividir por zero!";
                } else {
                    resultadoCalculadora = "Resultado da divisão: " + (numero1 / numero2);
                }
            }
        } catch (NumberFormatException e) {
            resultadoCalculadora = "Erro: Por favor, insira números válidos.";
        }

        // Passando o resultado para a página JSP
        request.setAttribute("resultadoCalculadora", resultadoCalculadora);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void processarVerificacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obter parâmetros do formulário de verificação
        int numeroA = 0, numeroB = 0;
        String tipoVerificacao = request.getParameter("tipoVerificacao");
        String resultadoVerificacao = "";

        try {
            // Converter os números para inteiros
            numeroA = Integer.parseInt(request.getParameter("numeroA"));
            numeroB = Integer.parseInt(request.getParameter("numeroB"));
            
            // Verificar se os números são positivos
            if (numeroA <= 0 || numeroB <= 0) {
                resultadoVerificacao = "Erro: Os números devem ser positivos!";
            } else {
                // Realizar a verificação solicitada
                if ("multiplo".equals(tipoVerificacao)) {
                    resultadoVerificacao = verificarMultiplo(numeroA, numeroB);
                } else if ("divisor".equals(tipoVerificacao)) {
                    resultadoVerificacao = verificarDivisor(numeroA, numeroB);
                }
            }
        } catch (NumberFormatException e) {
            resultadoVerificacao = "Erro: Por favor, insira números inteiros válidos.";
        }

        // Passar o resultado para a página JSP
        request.setAttribute("resultadoVerificacao", resultadoVerificacao);
        request.getRequestDispatcher("/verifica.jsp").forward(request, response);
    }

    private String verificarMultiplo(int a, int b) {
        if (a % b == 0) {
            return a + " é múltiplo de " + b;
        } else {
            return a + " não é múltiplo de " + b;
        }
    }

    private String verificarDivisor(int a, int b) {
        if (b % a == 0) {
            return a + " é divisor de " + b;
        } else {
            return a + " não é divisor de " + b;
        }
    }
}