#Maximum Height by Stacking Blocks

This application calculates the maximum height by stacking the blocks provided in the input request.

Command to Run Application from project base directory: ./gradlew bootRun

Application End Point: http://localhost:8080/v1/anz/stackingBlocks

Sample Input Format:

{ "requestBlockList": [{
	"length":50,
	"width":45,
	"height":20
	},
	{
	"length":95,
	"width":37,
	"height":53
	},
	{
	"length":45,
	"width":23,
	"height":12
	}]
	}
  
  list of blocks mentioned in the request JSON as array of elements.
  
 Output:
 
 {
    "maxHeight": "190"
 }

 
 

