# Assignment 1

## Reflections - Task 1

### Shooting

`A woman fired a shot at a man with her gun, but the man did not die. List the possible
reasons for the man not dying.`

- The woman missed her target.
- The man was not fatally injured.
- The gun had no more bullets.
- The bullet was not harmful.
- The man was able to dodge the bullet.

### Alien

`An alien meets you and it asks you to teach it how to brush its teeth. Assume that the
alien has teeth exactly like yours, and is as smart as you, but it needs a clear step-by-step
instruction. List the steps. Be as detailed as you can. (Example: Hold the toothpaste with
your left hand; turn the cap anti-clockwise)`

1. Find the toothpaste and hold it with your left hand.
2. Turn the toothpaste cap anti-clockwise until it comes of.
3. Place the toothpaste cap and put on the counter.
4. Put the now opened toothpaste in your right hand.
5. Find the toothbrush and hold it with your left hand.
6. Put the head of your toothpaste at the top of your toothbrush where the hair is sticking out.
7. Gently squish the middle of the toothpaste onto the top part of the hair portion of your toothbrush, until it fills
   up about 50 percent of the toothbrush hair. The toothpaste height should only be about 10 millimeters.
8. Put the toothpaste on the counter, so that you are now holding only the toothbrush.
9. Put the toothbrush in whatever hand feels most natural.
10. Put the toothbrush into your mouth, starting on the left side of your mouth.
11. Put the toothbrush on the furthest back tooth at the bottom of your mouth.
12. Brush the top of that tooth turning the toothbrush so that the hair portion touches your tooth. Make sure you are
    brushing it on all sides.
13. Follow the row of teeth to your right, until the end tooth on right side of your mouth.
14. Turn the toothbrush 180 degrees, so that the hair is pointing towards the top of your mouth.
15. Put the toothbrush onto the tooth furthest to the right in the top portion of your mouth.
16. Repeat the steps used to brush the bottom portion, this time just going from the right to left.

## Two Katas - Task 2

### Project Structure

#### Endpoints

Three endpoints are exposed through
the [ConverterController](src/main/java/io/github/tobiasz/testola1/controller/ConverterController.java)

```http request
GET /convert/fahrenheit-to-celsius?fahrenheit=100
```

```http request
GET /convert/celsius-to-fahrenheit?celsius=30
```

```http request
GET /convert/arabic-to-roman?arabic=10000
```

#### Cucumber Setup

Setting up cucumber with spring boot to allow autowiring of things such as MockMvc and others was a bit of a hassle
because they can't all have the `@CucumberContextConfiguration` annotation. So to allow multiple files
the [cucumberconfig](src/test/java/io/github/tobiasz/testola1/acceptance/cucumberconfig) package was created. It makes
it so that all cucumber step classes in the `acceptance` package will be run using the annotations from
the `CucumberSpringContextConfig` class. (yes it's weird)

### FAHRENHEIT-TO-CELSIUS CONVERTER

- [Celsius to Fahrenheit feature](src/test/resources/features/fahrenheit-to-celsius.feature)
- [Feature Implementation](src/test/java/io/github/tobiasz/testola1/acceptance/FahrenheitToCelsiusAcceptanceTest.java)
- [Unit Tests](src/test/java/io/github/tobiasz/testola1/service/FahrenheitToCelsiusConverterServiceTest.java)
- [Actual implementation](src/main/java/io/github/tobiasz/testola1/service/ConverterService.java)

### CELSIUS-TO-FAHRENHEIT CONVERTER

- [Celsius to Fahrenheit feature](src/test/resources/features/celsius-to-fahrenheit.feature)
- [Feature Implementation](src/test/java/io/github/tobiasz/testola1/acceptance/CelsiusToFahrenheitAcceptanceTest.java)
- [Unit Tests](src/test/java/io/github/tobiasz/testola1/service/CelsiusToFahrenheitConverterServiceTest.java)
- [Actual implementation](src/main/java/io/github/tobiasz/testola1/service/ConverterService.java)

### ROMAN NUMERAL KATA

- [Celsius to Fahrenheit feature](src/test/resources/features/arabic-to-roman.feature)
- [Feature Implementation](src/test/java/io/github/tobiasz/testola1/acceptance/ArabicToRomanAcceptanceTest.java)
- [Unit Tests](src/test/java/io/github/tobiasz/testola1/service/ArabicToRomanConverterServiceTest.java)

Implementation is done through these classes:

- [Service](src/main/java/io/github/tobiasz/testola1/service/ConverterService.java)
- [RomenNumeralPart](src/main/java/io/github/tobiasz/testola1/config/RomenNumeralPart.java)
- [RomenNumeralPartConfig](src/main/java/io/github/tobiasz/testola1/config/RomenNumeralPartConfig.java)
- [RomenNumeralPartFactory](src/main/java/io/github/tobiasz/testola1/factory/RomenNumeralPartFactory.java)

## Thoughts on BDD - Task 3

- What was positive and good about using BDD?

Using BDD helped a lot in understanding the actual problem I was facing. It pretty much just forces a developer to think
before acting.

It also makes sure you have an idea about the whole flow of the current scenario you're working on. For instance, it
forced be to think about how the outside would communicate with the feature. In this case through a rest endpoint.

- What was annoying or difficult?

Initially getting Cucumber to work as expected was a bit of a struggle.

There is generally a lot of code that has to be written for each scenario. Albeit I could definitely set up some
reusable
code that for the places which are almost doing the same thing.

- What surprised you?

Ones I got everything working correctly it was a rather smooth workflow, as well as usually an error free one, if the
features were correctly set up.
