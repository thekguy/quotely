# Quotely

A command line interface written in Java which takes as an argument English or Russian and returns a quote from the forismatic API with the correct language. If a language is not specified, default to English.

# Table of contents

- [Usage](#usage)
- [Installation](#installation)

# Usage

[(Back to top)](#table-of-contents)

java -jar target/quotely-0.0.1-SNAPSHOT-jar-with-dependencies.jar [English|Russian]


# Installation

[(Back to top)](#table-of-contents)

1. Install JDK 11 and Maven.
2. Clone this repository into a directory named quotely.
3. Run `cd quotely`.
4. Run `mvn clean compile assembly:single`.
