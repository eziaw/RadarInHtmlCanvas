import java.io.File

class GenerateCanvas {

    companion object {
        @JvmStatic fun main(args: Array<String>) {

            fun generateScript() {
                val jsFile = File("script.js")
                jsFile.writeText(
                    "const randInRange = (min, max) => Math.floor(Math.random() * (max - min)) + min; \n" +
                            "function drawRadar(ringsNum, techAmount) {\n" +
                            "var point_size = 5;\n" +
                            "var c = document.getElementById(\"radar\");\n" +
                            "var ctx = c.getContext('2d');\n" +

                            "function drawCoordSys(ringsNum, ringSize, dash) {\n" +
                            "ctx.beginPath();\n" +
                            "ctx.setLineDash([dash, dash]);\n" +
                            "ctx.moveTo(ringsNum*ringSize, 0);\n" +
                            "ctx.lineTo(ringsNum*ringSize, ringsNum*ringSize*2);\n" +
                            "ctx.stroke();\n" +
                            "ctx.beginPath();\n" +
                            "ctx.moveTo(0, ringsNum*ringSize);\n" +
                            "ctx.lineTo(ringsNum*ringSize*2, ringsNum*ringSize);\n" +
                            "ctx.stroke();\n" +
                            "ctx.setLineDash([0, 0]);\n" +
                            "}\n" +

                            "function drawCircle(center_x, center_y, radius) {\n" +
                            "ctx.beginPath();\n" +
                            "ctx.arc(center_x, center_y, radius, 0, 2*Math.PI);\n" +
                            "ctx.stroke();\n" +
                            "}\n" +

                            "function drawPoint(center_x, center_y, angle, radius, ringNum, ringSize, label) {\n" +
                            "ctx.fillStyle = 'black'; \n" +
                            "var x = center_x + (radius+ringNum*ringSize) * Math.cos(-angle*Math.PI/180);\n" +
                            "var y = center_y + (radius+ringNum*ringSize) * Math.sin(-angle*Math.PI/180);\n" +

                            "ctx.beginPath();\n" +
                            "ctx.arc(x, y, point_size, 0, 2 * Math.PI);\n" +
                            "ctx.fill();\n" +
                            "ctx.font = 'bold 5px arial';\n" +
                            "ctx.fillStyle = 'white'; \n" +
                            "ctx.fillText(label,x,y);\n" +
                            "}\n" +

                            "drawCoordSys(ringsNum, 100, 5) \n" +
                            "for(i=1; i<=ringsNum; i++) { \n" +
                            "drawCircle(ringsNum*100, ringsNum*100, i*100);\n" +
                            "}\n" +
                            "for(i=1; i<=techAmount; i++) { \n" +
                            "drawPoint(ringsNum*100, ringsNum*100, randInRange(0, 360), randInRange(0, 100), randInRange(0, 4), 100, i);\n" +
                            "}" +
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
                            "<body onload=\"drawRadar("+ringsNum+","+techAmount+")\">\n" +
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