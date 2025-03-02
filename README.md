# Meringue

Meringue is a Maven plugin for running and analyzing fuzzing campaigns.

## Requirements

* Java Development Kit 8
* [Apache Maven](https://maven.apache.org/) 3.6.0+

## Building Meringue

1. Ensure that some version of OpenJDK 8 is installed.
2. Set the JAVA_HOME environmental variable to the path to this installation. For example, on Mac,
   run `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_222-openjdk/Contents/Home/`.
3. Clone or download this repository.
4. In the root directory for this project, run `mvn -DskipTests install`.

## Running Examples

The following instructions assume that you have already built Meringue according to the above instructions. To run an
example fuzzing campaign run:

```
mvn -fmeringue-examples -P<FRAMEWORK>,<SUBJECT> [-Dmeringue.duration=<X>] [-Dmeringue.debug] verify
```

Where:

* \<FRAMEWORK\> is one of the following: "zest" or "jazzer"
* \<SUBJECT\> is one of the following: "ant", "maven", "bcel", "closure", or "rhino"
* \<X\> is the maximum amount of time to execute the fuzzing campaign for specified in the ISO-8601 duration format (
  e.g., 2 days, 3 hours and 4 minutes is "P2DT3H4M"). The default value is one day.
* The presence of -Dmeringue.debug indicates that forked analysis JVMs should suspend and wait for a debugger to attach.
  By default, forked analysis JVMs do not suspend and wait for a debugger to attach.

When the fuzzing campaign has completed, Meringue will rerun the inputs that were saved during the campaign to produce a JaCoCo coverage report and a report listing observed failures.

## License

This software release is licensed under the BSD 3-Clause License.

Copyright (c) 2022, Katherine Hough and Jonathan Bell.

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
   disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
   disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
