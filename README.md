# osmi-paas
A simple micro services architecture with docker

Docker and gradle have to be installed.

To start this simple micro service example, simply run:

- gradle assemble -b ./service-a/build.gradle
- gradle assemble -b ./service-b/build.gradle
- docker-compose up

You can access Service B through http://docker.local:12346

![architecture](https://raw.githubusercontent.com/og84/osmi-paas/master/vfhpse-paas.png)