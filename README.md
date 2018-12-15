# Cat Suite
Spring cataloging app POC

Docker steps:
    docker build -t marshhawk/cat-suite-builder:$(git rev-parse HEAD) -f Dockerfile.builder .

    docker push marshhawk/cat-suite-builder:$(git rev-parse HEAD)

    docker run --rm -v "$PWD:/work" marshhawk/cat-suite-builder:$(git rev-parse HEAD) bash -c "cd /work; gradle bootJar"

TODOS
 - Jar versioning solution or just use git hash
 - query by specific data fields
 - fancy holdings stuff?
