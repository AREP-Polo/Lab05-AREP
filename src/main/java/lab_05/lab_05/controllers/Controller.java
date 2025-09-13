package lab_05.lab_05.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Nella says: %s!";

    @GetMapping(value = "/", produces = "text/html")
    public String welcome() {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Bienvenido - Lab 05</title>
                    <style>
                        body {
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            margin: 0;
                            padding: 0;
                            min-height: 100vh;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                        }
                        .container {
                            background: white;
                            border-radius: 20px;
                            padding: 40px;
                            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.1);
                            text-align: center;
                            max-width: 500px;
                            width: 90%;
                        }
                        h1 {
                            color: #333;
                            margin-bottom: 20px;
                            font-size: 2.5em;
                        }
                        p {
                            color: #666;
                            line-height: 1.6;
                            margin-bottom: 30px;
                            font-size: 1.1em;
                        }
                        .lab-info {
                            background: #f8f9fa;
                            padding: 20px;
                            border-radius: 10px;
                            margin: 20px 0;
                        }
                        .greeting-link {
                            display: inline-block;
                            background: #667eea;
                            color: white;
                            text-decoration: none;
                            padding: 12px 24px;
                            border-radius: 25px;
                            font-weight: bold;
                            transition: all 0.3s ease;
                        }
                        .greeting-link:hover {
                            background: #764ba2;
                            transform: translateY(-2px);
                        }
                        .footer {
                            margin-top: 30px;
                            font-size: 0.9em;
                            color: #999;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>¡Bienvenido!</h1>
                        <p>Esta es la página de bienvenida del Laboratorio 05 de TDSA</p>

                        <div class="lab-info">
                            <h3>Información del Laboratorio</h3>
                            <p><strong>Estudiante:</strong> Marianella Polo</p>
                            <p><strong>Curso:</strong> TDSA</p>
                            <p><strong>Laboratorio:</strong> 05</p>
                        </div>

                        <p>Explora las funcionalidades disponibles:</p>
                        <a href="/greeting" class="greeting-link">Ir a Saludo</a>

                        <div class="footer">
                            <p>Desarrollado con Spring Boot</p>
                        </div>
                    </div>
                </body>
                </html>
                """;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }
}