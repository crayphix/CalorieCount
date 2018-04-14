# Calories
CalCount is a basic calorie tracking java app that prompts the user with three options.

1) Create new file
2) Edit existing file
3) View existing file

1) Create new file
    -prompt user to enter date
      -create file with the name of date entered
    -Call addFood
      -prompt user for name of food 
        -creates Calorie object and assigns it a name
         -prompt user for calories
         -assigns calories to the Calorie object
         -writes calorie object data to file 
         -prompt user to 
           1) Enter more items
           2) Exit

               1) Enter more items
                 - recall addFood
               2)
                 - close file and exit

2) Edit existing file
    -prompt user for date to modify
      -import file data and display
      -prompt user to select item to 
        1) modify 
        2) create new item

            1) Modify
              -prompt user to enter item to modify 
                -prompt user to 
                  1) edit item calories
                    -prompt user for new calories
                    -write calories to object 
                  2) delete item
                    -delete 
                -prompt user to 
                  1) make another edit
                  2) exit
                    1) Make another edit
                      -Edit existing file
                    2) Exit
                      -close file and exit

            2) Create new item
                -recall addFood