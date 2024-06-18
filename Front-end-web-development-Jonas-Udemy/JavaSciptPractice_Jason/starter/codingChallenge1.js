const massMark = 78;
const heightMark = 1.69;
const massJohn = 92;
const heightJohn = 1.95;

const BMIMark = massMark / heightMark ** 2;
const BMIJohn = massJohn / (heightJohn * heightJohn);
const isMarkHigherBMI = BMIMark > BMIJohn;

console.log(BMIMark, BMIJohn);
console.log(BMIMark, BMIJohn, isMarkHigherBMI);

/*
console.log(
  "Mark BMI is " +
    BMIMark +
    "\nJohn BMI is " +
    BMIJohn +
    "\nIs Mark BMI higher than John BMI? " +
    isMarkHigherBMI
);
*/
console.log(
  `Mark BMI is ${BMIMark} and John BMI is ${BMIJohn}. Is Mark BMI higher than John BMI? ${isMarkHigherBMI}`
);
