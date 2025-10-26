# Aeron Transport, SBE Encoding Examples

This repository demonstrates how to use [Aeron](https://aeron.io/) and [SBE](https://github.com/aeron-io/simple-binary-encoding/wiki/FIX-SBE-XML-Primer) to build Java applications that communicate over the [FIX protocol](https://www.fixtrading.org/).

## Current State
You can run successfully posting new orders both market and limit.
These will get matched and execution reports generated.
This is simulated in IntegrationTests using Aeron to communicate
with MatchingEngine. This is explained later.
Order modify (OCRR) and cancel (OCR) is not yet supported.

## Features

- ✅ Create `NewOrderSingle` (type `D`) and other standard FIX messages
- ✅ Set up **Initiator** (client) and **Acceptor** (server)
- ✅ Send/receive FIX messages over Aeron
- ✅ Use standard FIX fields and custom fields

![img.png](img.png)

## Important Issue to Fix before Running
Aeron media driver, Java Main (matching engine), and IntegrationTests must share same shared memory folder.
Just search for /tmp/aeron right now in use.
On Windows PC you will need to replace with C;\... etc.
This is needed in three places, aeron starter i.e. run.sh, Main.java, and IntegrationTests.java.

## How to Run (Steps)
* Start Aeron Media Driver - cd aeron && ./run.sh
* Start Matching Engine - gradle run
* Run IntegrationTests - gradle :matchingengine:test --tests "com.codingmonster.matchingengine.IntegrationTests"

#### Start Media Driver
cd aeron
curl -O https://repo1.maven.org/maven2/io/aeron/aeron-all/1.44.0/aeron-all-1.44.0.jar

java \
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
-Daeron.dir=/tmp/aeron \
-Daeron.dir.delete.on.start=true \
-Daeron.print.configuration=true \
-Daeron.event.log=true \
-Daeron.client.liveness.timeout=10000000000 \
-Daeron.driver.timeout=60000 \
-cp aeron-all-1.44.0.jar io.aeron.driver.MediaDriver

.. or just do `./run.sh`. This is a script in aeron folder.

#### Start Matching Engine


#### Run Integration Tests
