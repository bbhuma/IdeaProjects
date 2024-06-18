const dolphinsFirstScore = 97;
const dolphinsSecondScore = 12;
const dolphinsThirdScore = 21;
const koalasFirstScore = 19;
const koalasSecondScore = 15;
const koalasThirdScore = 103;

const avgOfDolphins =
  (dolphinsFirstScore + dolphinsSecondScore + dolphinsThirdScore) / 3;
const avgOfKoalas =
  (koalasFirstScore + koalasSecondScore + koalasThirdScore) / 3;

console.log(
  `Dolphins has an average of ${avgOfDolphins} and Koalas has an average of ${avgOfKoalas}`
);
const isDolphinsAvgGreaterKoalas = avgOfDolphins > avgOfKoalas;
const dolphonsHasMinimumScore100 =
  dolphinsFirstScore > 100 ||
  dolphinsSecondScore > 100 ||
  dolphinsThirdScore > 100;

const koalasHasMinimumScore100 =
  dolphinsFirstScore > 100 ||
  dolphinsSecondScore > 100 ||
  dolphinsThirdScore > 100;

// console.log(isDolphinsAvgGreaterKoalas && dolphonsHasMinimumScore100);
if (isDolphinsAvgGreaterKoalas && dolphonsHasMinimumScore100) {
  console.log(`YAY! Dolphins are the winners today💕`);
} else if (!isDolphinsAvgGreaterKoalas && koalasHasMinimumScore100)
  console.log(`YAY! Koalas are the winners today💕.`);
else if (
  avgOfDolphins === avgOfKoalas &&
  dolphonsHasMinimumScore100 &&
  !koalasHasMinimumScore100
)
  console.log(`YAY! Dolphins are the winners today💕.`);
else if (
  avgOfDolphins === avgOfKoalas &&
  !dolphonsHasMinimumScore100 &&
  koalasHasMinimumScore100
)
  console.log(`YAY!  Koalas are the winners today💕.`);
else if (
  avgOfDolphins === avgOfKoalas &&
  dolphonsHasMinimumScore100 &&
  koalasHasMinimumScore100
)
  console.log(
    `YAY! Dolphins and Koalas are the winners today💕.The Game is a DRAW today.`
  );
else console.log(`OOPS! No team wins today💕`);

/*
const avgDolphins = (97 + 112 + 100) / 3;
const avgKoalas = (109 + 95 + 81) / 3;
if (avgDolphins > avgKoalas && avgDolphins >= 100)
  console.log(`YAY! Dolphins win the GAME😊`);
else if (avgKoalas > avgDolphins && avgKoalas >= 100)
  console.log(`YAY! Koalas win the GAME😊`);
else if (avgDolphins === avgKoalas && avgDolphins >= 100 && avgKoalas >= 100)
  console.log(`YAY! Dolphins and Koalas win the GAME today😊`);
else console.log(`OOPS! No team wins today!😢`);
*/
