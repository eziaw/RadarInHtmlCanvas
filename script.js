const randomInRange = (min, max) => Math.floor(Math.random() * (max - min)) + min;function drawRadar(ringsNum, techAmount) {
c = document.getElementById("radar");
ctx = c.getContext("2d");
ctx.beginPath();
ctx.setLineDash([5, 5]);
ctx.moveTo(ringsNum*100, 0);
ctx.lineTo(ringsNum*100, ringsNum*100*2);
ctx.stroke();
ctx.beginPath();
ctx.moveTo(0, ringsNum*100);
ctx.lineTo(ringsNum*100*2, ringsNum*100);
ctx.stroke();
ctx.setLineDash([0, 0]);
for(i=1; i<=ringsNum; i++) {
ctx.beginPath();
ctx.arc(ringsNum*100, ringsNum*100, 100*i, 0, 2*Math.PI);
ctx.stroke();
}
ctx.fillStyle = 'blue';
for(i=1; i<=techAmount; i++) {
r = ringsNum*100 * Math.sqrt(Math.random())
theta = Math.random()*2*Math.PI
x = ringsNum*100 + r * Math.cos(theta)
y = ringsNum*100 + r * Math.sin(theta)
ctx.fillRect(x, y, 10,10);
}
}