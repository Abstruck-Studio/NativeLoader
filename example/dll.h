#ifndef _DLL_H_
#define _DLL_H_

#if BUILDING_DLL
#define DLLIMPORT __declspec(dllexport)
#else
#define DLLIMPORT __declspec(dllimport)
#endif
#include "native_loader.h"

DLLIMPORT void onInitialize(Logger);
DLLIMPORT void onInitializeClient(Logger);

#endif
