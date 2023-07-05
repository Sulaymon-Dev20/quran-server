
![test](https://github.com/evan361425/flutter-pos-system/workflows/test/badge.svg?branch=master)
[![Apache 2.0](https://img.shields.io/github/license/nebula-plugins/gradle-netflixoss-project-plugin.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![version](https://img.shields.io/github/v/tag/evan361425/flutter-pos-system)](https://github.com/evan361425/flutter-pos-system/releases/latest)
[![codecov](https://codecov.io/gh/evan361425/flutter-pos-system/branch/master/graph/badge.svg?token=KCMZRMU47V)](https://codecov.io/gh/evan361425/flutter-pos-system)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a3713a1200f340e78f7209f4a55be993)](https://www.codacy.com/gh/evan361425/flutter-pos-system/dashboard?utm_source=github.com&utm_medium=referral&utm_content=evan361425/flutter-pos-system&utm_campaign=Badge_Grade)
# بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ
Holy Quran Application <br/> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum

****
## Project installation for devices
- [x] [Linux](#linux-ubuntu-distro)
- [x] [MAC OS](#macos)
- [x] [DOCKER](#docker)
****
## Project using prosses
- [x] IOS
- [ ] ANDROID
- [ ] FRONT END

## API documentation
[Swagger](http://localhost:6236/swagger-ui/index.html)
****
### Linux Ubuntu distro
* setup redis
  ```shell 
  sudo apt update && sudo apt install redis
   ```
* setup java 17
  ```shell 
  sudo apt install openjdk-17-jdk openjdk-17-jre
   ```
* setup git
  ```shell 
  sudo apt install git
   ```
* clone project
  ```shell 
  git clone https://github.com/Sulaymon-Dev20/quran-online
   ```
* run project
  ```shell 
  mvn spring-boot:run
  ```
****
### Macos
* install brew
  ```zsh
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  ```
* setup java 17
  ```zsh 
  brew update && brew install openjdk@17
   ```
* setup git
  ```zsh 
  brew install git
   ```
* clone project
  ```zsh 
  git clone https://github.com/Sulaymon-Dev20/quran-online
   ```
* run project
  ```zsh 
  mvn spring-boot:run
  ```
****
### Docker
* docker pull ~~~~~~~~~~~
  ```zsh 
  docker pull
   ```
* docker run project
  ```zsh 
  docker run -p 6236:6236 
  ```
****
**Project path**
```txt
quran
├── README.md
├── data
│   ├── chapters.json
│   ├── editions
│   │   ├── bn.json
│   │   ├── en.json
│   │   ├── es.json
│   │   ├── fr.json
│   │   ├── id.json
│   │   ├── ru.json
│   │   ├── sv.json
│   │   ├── tr.json
│   │   ├── ur.json
│   │   ├── uz.json
│   │   └── zh.json
│   ├── juz.json
│   └── quran.json
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com.suyo.quran
        │       ├── QuranApplication.java
        │       ├── config
        │       │   ├── CorsConfig.java
        │       │   ├── GlobalExceptionHandler.java
        │       │   └── SpringFoxConfig.java
        │       ├── controller
        │       │   ├── ChapterController.java
        │       │   ├── JuzController.java
        │       │   └── VersesController.java
        │       ├── models
        │       │   ├── Language.java
        │       │   ├── Response.java
        │       │   └── Status.java
        │       ├── service
        │       │   ├── ChapterService.java
        │       │   ├── DataService.java
        │       │   ├── JuzService.java
        │       │   └── VersesService.java
        │       └── util
        │           ├── BadController.java
        │           ├── ColorsTerminal.java
        │           ├── CronContent.java
        │           ├── IpService.java
        │           ├── PageContent.java
        │           └── Utils.java
        └── resources
            ├── application.properties
            ├── banner.txt
            ├── dist
            │   └── quran.json
            └── static
                └── utilLogos.png
```
