def call(name) {
    // sh "echo Hello ${config.name}. Today is ${config.dayOfWeek}."
  echo "${name}"
  sh '$PWD'
  final pythonContent = libraryResource('./test.py')
  // There are definitely better ways to do this without having to write to the consumer's workspace
  writeFile(file: 'test.py', text: pythonContent)
  sh("chmod +x test.py && ./test.py ${name}")

}
