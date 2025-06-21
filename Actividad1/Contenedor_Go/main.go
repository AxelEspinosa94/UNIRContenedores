package main

import (
	"fmt"
	"net/http"
	"time"
)

func handler(w http.ResponseWriter, r *http.Request) {
	currentTime := time.Now()
	fmt.Fprintf(w, "Current time is: %s", currentTime.Format(time.RFC1123))
}

func main() {
	http.HandleFunc("/", handler)
	port := "4000" // Puerto interno, mapea a otro en el host
	fmt.Println("Server listening on port " + port)
	http.ListenAndServe(":" + port, nil)
}