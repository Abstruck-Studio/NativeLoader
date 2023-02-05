#ifndef _NATIVE_LOADER_UTIL_
#define _NATIVE_LOADER_UTIL_
#include <stdbool.h>

struct JNALogger {
	void (*info)(char*);
	void (*warn)(char*);
	void (*error)(char*);
	void (*debug)(char*);
	void (*trace)(char*);
};

#endif 
