

FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8

ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn  dependency:resolve

ADD src /tmp/build/src

RUN cd /tmp/build && mvn  -DskipTests=true  compile 





