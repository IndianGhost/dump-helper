# indianghost-dumphelper (v1.0.0) ![version1.0.0](https://img.shields.io/badge/version-1.0.0-green.svg) [![MIT](https://img.shields.io/badge/license-MIT-green)](https://github.com/IndianGhost/dump-helper/blob/main/LICENSE)
**indianghost-dumphelper** is a lightweight package providing a dump helper that can print an object in json format or structured text.
It is hightly recommended to use it in log files when it's not possible to debug objects in localhost.

## Requirements
- JDK 1.8+

## Install
### Maven
```
<dependency>
    <groupId>io.github.indianghost</groupId>
    <artifactId>indianghost-dumphelper</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Gradle
```
implementation group: 'io.github.indianghost', name: 'indianghost-dumphelper', version: '1.0.0'
```
### Gradle (Short)
```
implementation 'io.github.indianghost:indianghost-dumphelper:1.0.0'
```
## Gradle (Kotlin)
```
implementation("io.github.indianghost:indianghost-dumphelper:1.0.0")
```
## SBT
```
libraryDependencies += "io.github.indianghost" % "indianghost-dumphelper" % "1.0.0"
```
## Ivy
```
<dependency org="io.github.indianghost" name="indianghost-dumphelper" rev="1.0.0"/>
```
## Grape
```
@Grapes(
    @Grab(group='io.github.indianghost', module='indianghost-dumphelper', version='1.0.0')
)
```
## Leiningen
```
[io.github.indianghost/indianghost-dumphelper "1.0.0"]
```
## Buildr
```
'io.github.indianghost:indianghost-dumphelper:jar:1.0.0'
```

## Examples of use
First of all you should import the class **DumpHelper**:  
`import io.github.indianghost.DumpHelper;`  
Then you can use the method **dumpProperties(obj)** as:  
`log.info(DumpHelper.dumpProperties(entityForDemo));`  
to get the output:  
```
io.github.indianghost.EntityForDemo@351d0846[
  age=30
  marks=[9.62, 11.14, 17.0]
  name=Lorem ipsum
]
```
Or, you can use the method **dumpAsJson(obj)** as:  
`log.info(DumpHelper.dumpAsJSON(entityForDemo));`  
to get the output:  
```
{
  "name" : "Lorem ipsum",
  "age" : 30,
  "marks" : [ 9.62, 11.14, 17.0 ]
}
```
## Copyright and license
Copyright 2022 Achraf BELLAALI **indianghost-dump-helper** is a free open-source project. The code is released under [The MIT LICENSE](https://github.com/IndianGhost/dump-helper/blob/main/LICENSE) you can do whatever you want with it !

## Support My development
If you found it helpful, you can support me to develop new projects By :
[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://www.paypal.me/achrafbellaali)