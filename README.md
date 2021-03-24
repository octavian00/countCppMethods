# MECO
Meco is a open source project, a tool that parse a directory, counts methods from each cpp file and put the result in a json file which can be uploaded as property file in dxPlatform

## Technologies
We use Kotlin as programming language to build this tool. For obtain number of methods we use universal ctags tool and for write data in a pretty JSON format,
GSON help us.
[Universal ctags](https://ctags.io/) is a maintained implementation of ctags. Ctags is a programming tool that generates an index file of names found in source files and header files of various programming languages.
Depending on the language, functions, variables, class members, macros and so on may be indexed.

## Installing

### From Github
To install Meco from Github, please download meco.zip from the [latest_release](https://github.com/octavian00/countCppMethods/releases/tag/v1)

The contains from the archive are:

`ces-count-cpp-methods.jar` - the executable jar file

Or you can download source code from [here](https://github.com/octavian00/countCppMethods) 

Run `mvn clean install` in the folder from archive

### From Code
Clone the repository from [here](https://github.com/octavian00/countCppMethods)

Run `mvn clean install` in /countCppMethods 


## Running the tool

### Running with docker
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
 
### Running with linux
 
 First of all you must have installed jdk and ctags
 
 #### jdk 11  on ubuntu 
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

## Results

Once you have some dates the Methods.json file you can upload on dxPlatform as property file.

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

## Contribute
We are close to collaborations.

## Credits
Thanks to Ken Arnold for developing the ctags and to team that maintain [universal ctags](https://github.com/universal-ctags/ctags). We used this tool to get the number of methods in the cpp files.

## Contact
Contact us for additional help:
vilceanu_octavian@yahoo.com
radutit@yahoo.com

## License 
[GNU GPL](https://choosealicense.com/licenses/gpl-2.0/)
