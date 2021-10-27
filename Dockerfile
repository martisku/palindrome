FROM openjdk:11
WORKDIR /
ADD Palindrome.jar Palindrome.jar
EXPOSE 8080
CMD java - jar Palindrome.jar
