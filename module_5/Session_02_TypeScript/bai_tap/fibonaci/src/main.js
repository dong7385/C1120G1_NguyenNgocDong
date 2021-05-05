var n0 = 0;
var n1 = 1;
var n2;
var i = 0;
console.log(n0);
console.log(n1);
while (i < 18) {
    n2 = n0 + n1;
    console.log(n2);
    n0 = n1;
    n1 = n2;
    i++;
}
