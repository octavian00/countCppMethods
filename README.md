#MECO
This plugin counts methods from cpp files and put the result in a json file which can be uploaded in dxPlatform

##Installing

###From Github
To install Meco from Github, please download meco.zip from the [latest_release](https://github.com/octavian00/countCppMethods/releases/tag/v1)

The contains from the archive are:

`ces-count-cpp-methods.jar` - the executable jar file

Or you can download source code from [here](https://github.com/octavian00/countCppMethods) 

Run `mvn clean install` in the folder from archive

###From Code
Clone the repository from [here](https://github.com/octavian00/countCppMethods)

Run `mvn clean install` in /countCppMethods 


##Running the tool

###Running with docker
We have created a docker image `octavianvilceanu/countcppmehtodsv1`

For running the tool with docker you must have instaled docker on your machine and paste following command

 ```bash 
docker run -v YourPathForTheProject:/workspace/project -v YourPathForResults/Methods.json:/workspace/Methods.json -it octavianvilceanu/countcppmehtodsv1
```
 
 YourPathForTheProject is your locally path where you have the project.
 
 ex: `/home/tavi/Desktop/microsoftTerminal/terminal`
 
 YourPathForResults is your locally path where you expected to have results
 
 ex: `/home/tavi/facultate/docker/Methods.json`
 
 Method.json is the file when the docker puts the output. It is necessary to create the blank file which have the name Methods.json
 
###Running with linux
 
 First of all you must have installed jdk and ctags
 
 ####jdk 11  on ubuntu 
 ```bash
apt update
apt upgrade
apt install openjdk-11-jdk
 ```
 
 #### ctags on ubuntu
 ```bash
apt-get install ctags
 ```
Then you should have jar of application `ces-count-cpp-methods.jar` which was created at Installing step

Now we can running the tool using the following command

```bash
java -jar ces-count-cpp-methods.jar DirectoryForProjectWhichYouWantToAnalyze
```

In the directory where you executed the command, you will see a file named Methods.json which contains de results 

##Results

Once you have some dates the Methods.json file you can upload on dxPlatform

The Methods.json file looks like:

```
[
{
    "file": "/workspace/project/src/propsheet/misc.cpp",
    "name": "Number of Methods",
    "category": "Methods",
    "value": 17
  },
  {
    "file": "/workspace/project/src/propsheet/registry.cpp",
    "name": "Number of Methods",
    "category": "Methods",
    "value": 5
  },
]
```
