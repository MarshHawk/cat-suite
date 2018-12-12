# Cat Suite
Spring cataloging app POC

Docker steps:
    docker build -t marshhawk/cat-suite-builder:$(git rev-parse HEAD) -f Dockerfile.builder .

    docker push marshhawk/cat-suite-builder:$(git rev-parse HEAD)

    docker run --rm -v "$PWD:/work" marshhawk/cat-suite-builder:$(git rev-parse HEAD) bash -c "cd /work; gradle bootJar"

TODOS
 - Finish dockerize
 - uery by specific data fields
 - follow steps here to add it to the new repo <https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/>

Install

