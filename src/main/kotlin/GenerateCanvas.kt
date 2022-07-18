import java.io.File

class GenerateCanvas {

    companion object {
        @JvmStatic fun main(args: Array<String>) {

            fun generateScript() {
                val jsFile = File("script.js")
                jsFile.writeText(
                    "const randomInRange = (min, max) => Math.floor(Math.random() * (max - min)) + min;" +
                            "function drawRadar(ringsNum, techAmount) {\n" +
                            "c = document.getElementById(\"radar\");\n" +
                            "ctx = c.getContext(\"2d\");\n" +
                            "ctx.beginPath();\n" +
                            "ctx.setLineDash([5, 5]);\n" +
                            "ctx.moveTo(ringsNum*100, 0);\n" +
                            "ctx.lineTo(ringsNum*100, ringsNum*100*2);\n" +
                            "ctx.stroke();\n" +
                            "ctx.beginPath();\n" +
                            "ctx.moveTo(0, ringsNum*100);\n" +
                            "ctx.lineTo(ringsNum*100*2, ringsNum*100);\n" +
                            "ctx.stroke();\n" +
                            "ctx.setLineDash([0, 0]);\n" +
                            "for(i=1; i<=ringsNum; i++) {\n" +
                            "ctx.beginPath();\n" +
                            "ctx.arc(ringsNum*100, ringsNum*100, 100*i, 0, 2*Math.PI);\n" +
                            "ctx.stroke();\n" +
                            "}\n" +
                            "ctx.fillStyle = 'blue';\n" +
                            "for(i=1; i<=techAmount; i++) {\n" +
                            "r = ringsNum*100 * Math.sqrt(Math.random())\n" +
                            "theta = Math.random()*2*Math.PI\n" +
                            "x = ringsNum*100 + r * Math.cos(theta)\n" +
                            "y = ringsNum*100 + r * Math.sin(theta)\n" +
                            "ctx.fillRect(x, y, 10,10);\n" +
                            "}\n" +
                            "}"
                )
            }

            fun generateHtml(ringsNum: Int, techAmount: Int) {
                val htmlFile = File("index.html")
                htmlFile.writeText(
                    "<!DOCTYPE HTML>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "<meta charset=\"utf-8\">\n" +
                            "<script src=\"script.js\"></script>\n" +
                            "</head>\n" +
                            "<body onload=\"drawRadar(" +ringsNum+ "," +techAmount+ ")\">\n" +
                            "<canvas id=\"radar\", width="+ ringsNum*250 +", height="+ ringsNum*250 +">\n" +
                            "</canvas>\n" +
                            "</body>\n" +
                            "</html>"
                )

            }

            generateScript()
            generateHtml(4, 72)
        }
    }
}