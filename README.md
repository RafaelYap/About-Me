# Rafael Yap — About Me

A portfolio available as a website and a Java Swing desktop app. Both highlight selected projects and link to their repositories.

## Deploy the website on Vercel

Import the GitHub repository `pogiko1345/About-Me` into Vercel. Choose **Other** as the framework preset, leave the build command blank, and use the repository root as the output directory. Vercel serves `index.html` at the site URL.

## Run the desktop app

Install Java 17 or newer, then run from this folder:

```sh
javac AboutMe.java
java AboutMe
```

The desktop app requires a graphical environment. Vercel displays the website in `index.html` instead.
