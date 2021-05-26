# ACCESS-Assignment

#### Finished with the total time of 6 hrs
- Architecture 2.5hr
- Layout 1 hr
- Logic 1hr
- Checking 1hr

#### Features

- MVVM Design
- LiveData / Observer Pattern
- Navigation / SafeArg
- DataBinding
- BindingAdapter
- Repository Design
- ViewModel Factory

Using the trait of MVVM, LiveData / Observer Pattern could play well within the task, combining with DataBinding allowing the UI to be data triggered, also BindingAdapter allow us to write all the logic within the class and execute when binding data to the XML variable. Most importantly, Repository Design allow us to have the ability to control or DB easily, but in this project is not necessary, and the ViewModelFactory is using delegate to assign the relevant ViewModel to the required fragments.
For improvement, it is supposed to create a alert builder to control all the exceptions coming from the response, or interceptor, if there were spec distributing all the exception types. And since the project only contains two views, instead of binding the close button to trigger back press, I used a global action of navigation instead.

For the Layout part, the only problem is on the detail part, cause it seems that the Bio field isn't required, so there might be the condition of being empty. Thus there is no SPEC telling what to do if the field is empty, but the ideal method would be using Barriers in the layout, so that the whole hole will shrink if the value is empty.