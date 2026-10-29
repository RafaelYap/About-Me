# Rafael Yap — About Me

A portfolio available as a website and a Java Swing desktop app. Both highlight selected projects and link to their repositories.

The website shows Rafael's age, calculated from his birth date when the page loads. The desktop app calculates it when it starts. The website's **Latest on GitHub** section loads three recently updated public, non-fork repositories from GitHub, so new public work appears without changing this repo. Featured projects and About Me text remain curated in `index.html`.

## Deploy the website on Vercel

Import the GitHub repository `RafaelYap/About-Me` into Vercel. Choose **Other** as the framework preset, leave the build command blank, and use the repository root as the output directory. Vercel serves `index.html` at the site URL.

## Run the desktop app

Install Java 17 or newer, then run from this folder:

```sh
javac AboutMe.java
java AboutMe
```

The desktop app requires a graphical environment. Vercel displays the website in `index.html` instead.
