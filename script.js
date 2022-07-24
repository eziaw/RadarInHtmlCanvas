const randInRange = (min, max) => Math.floor(Math.random() * (max - min)) + min; 
function drawRadar(ringsNum, techAmount) {
var point_size = 5;
var c = document.getElementById("radar");
var ctx = c.getContext('2d');
function drawCoordSys(ringsNum, ringSize, dash) {
ctx.beginPath();
ctx.setLineDash([dash, dash]);
ctx.moveTo(ringsNum*ringSize, 0);
ctx.lineTo(ringsNum*ringSize, ringsNum*ringSize*2);
ctx.stroke();
ctx.beginPath();
ctx.moveTo(0, ringsNum*ringSize);
ctx.lineTo(ringsNum*ringSize*2, ringsNum*ringSize);
ctx.stroke();
ctx.setLineDash([0, 0]);
}
function drawCircle(center_x, center_y, radius) {
ctx.beginPath();
ctx.arc(center_x, center_y, radius, 0, 2*Math.PI);
ctx.stroke();
}
function drawPoint(center_x, center_y, angle, radius, ringNum, ringSize, label) {
ctx.fillStyle = 'black'; 
var x = center_x + (radius+ringNum*ringSize) * Math.cos(-angle*Math.PI/180);
var y = center_y + (radius+ringNum*ringSize) * Math.sin(-angle*Math.PI/180);
ctx.beginPath();
ctx.arc(x, y, point_size, 0, 2 * Math.PI);
ctx.fill();
ctx.font = 'bold 5px arial';
ctx.fillStyle = 'white'; 
ctx.fillText(label,x,y);
}
drawCoordSys(ringsNum, 100, 5) 
for(i=1; i<=ringsNum; i++) { 
drawCircle(ringsNum*100, ringsNum*100, i*100);
}
for(i=1; i<=techAmount; i++) { 
drawPoint(ringsNum*100, ringsNum*100, randInRange(0, 360), randInRange(0, 100), randInRange(0, 4), 100, i);
}}