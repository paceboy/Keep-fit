// Copyright 2019 Baidu Inc. All rights reserved.
// Use of this source code is governed by a xxx
// license that can be found in the LICENSE file.

/*
modification history
--------------------
2019/09/24 13:34:59, by liushaogeng@baidu.com, create
*/

// Package main is special.  It defines a 
// standalone executable program, not a library. 
// Within package main the function main is also 
// special—it’s where execution of the program begins. 
// Whatever main does is what the program does.
package main

import (
	"fmt"
)

// main the function where execution of the program begins
func main() {
	fmt.Println("Hello, World!")
}
