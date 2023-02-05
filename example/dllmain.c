/* Replace "dll.h" with the name of your header */
#include "dll.h"
#include <windows.h>
#include <stdio.h>

#include "native_loader.h"



DLLIMPORT void onInitialize(Logger logger) {
	logger.info("onInitialize");
	logger.info("||||||||||||||||||||||||||||||||||||||||||||");
	logger.info("|                                          |");
	logger.info("|                                          |");
	logger.info("|                 NATIVE                   |");
	logger.info("|                                          |");
	logger.info("|                                          |");
	logger.info("||||||||||||||||||||||||||||||||||||||||||||");
}

DLLIMPORT void onInitializeClient(Logger logger) {
	logger.info("onInitializeClient");
}



