call \ms\dist\winaurora\proj\compat\incr \bin\useafs.cnd
REM Loading module oracle java jdk
call module load msjava/oraclejdk/1.8.0 162.1ms
REM Loading module gradle
call module load ossjava/gradle/4,2. 2ms
REM Setting the environment for Eclipse
gradle clean cleanEclipse eclipse
REM Setting the environment for Intellij Idea
gradle clean cleanIdea idea
pause