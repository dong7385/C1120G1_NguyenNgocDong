let n0: number = 0;
let n1: number = 1;
let n2: number;
let i: number = 0;

console.log(n0);
console.log(n1);
while (i < 18) {

    n2 = n0 + n1;
    console.log(n2)
    n0 = n1;
    n1 = n2;
    i++;
}
