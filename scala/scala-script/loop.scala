var i=0
while (i < args.length) {
  if (i != 0)
    print(" ")
    print(args(i))
    i +=1
}
println()

args.foreach(arg => println(arg))

args.foreach((arg: String) => println(arg))

args.foreach(println)