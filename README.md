## Ideas

### Design assumptions:

> - Console application - communication with the user from the console level
>- Data stored in a file on the local file system

### Requirements:

> - Catalog of questions and answers to them
>- Questions can have any number of answers
>- The answer cannot exist without the question
>- The questions are divided into categories
>- Each question must be assigned to exactly one category

### Example:

- Data model:

| model    | data                                                   |     
|----------|--------------------------------------------------------|
| Category | Free time                                              |  
| Question | How to spend the evening?                              | 
| Answer   | 1.Watch a movie <br> 2.Go for a walk <br> 3.Learn Java |

- Interaction with the console:

| command                                     | call method                                  | description                                         |
|---------------------------------------------|----------------------------------------------|-----------------------------------------------------|
| category add                                | addCategory()                                | Create a new category                               |
| category list                               | categoryList()                               | Displaying all categories                           |
| question add CategoryName <br> QuestionName | addQuestion(CategoryName, <br> QuestionName) | Create a new question <br> and add it to a category |
| question list                               | questionList()                               | Displaying all questions                            |
| answer add QuestionName <br> AnswerName     | addAnswer(QuestionName, <br> AnswerName)     | Create a new answer <br> and add it to a question   |
| answer list                                 | answerList()                                 | Displaying all answer                               |
| help                                        | helpApplication()                            | Description of using the console                    |
| quite                                       | quiteApplication()                           | Exit the program                                    |