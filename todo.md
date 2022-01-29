# TODO

## DAOS
- CrudDAO abstract class
- CharacterDAO
- UserDAO

## Exceptions
- InvalidStatisticValueException
- InvalidCharacterNameException
- InvalidUsernameException
- InvalidEmailException
- UsernameAlreadyExistsException
- EmailAlreadyExistsException

## Menus
- DONE Menu abstract class (getName, getRoute, render)
- DONE WelcomeMenu
- UserRegisterMenu
- UserLoginMenu
- CharacterGenerateMenu
- CharacterListMenu
- StatisticModifyMenu
- CharacterCompareMenu

## Models
- DONE MyCharacter (id, characterName, statistics[], userID)
- DONE User (id, userName, password, email)

## Services
- MyCharacterService (generateMyCharacter, updateStatistic, viewMyCharacter, compareMyCharacters, isCharacterNameValid, rollStatistic, isStatisticValid, printStatistic)
- UserService (registerNewUser, authenticateUser, isUserValid, isUsernameValid, isEmailValid, isStatisticValid)

## Util
- DONE AppState (public void startup, public static void shutdown)
- DONE Collection interface (add, contains, isEmpty, remove(element), size)
- DONE MyList interface (get)
- DONE MyArrayList implements List
- DONE MenuRouter (addMenu, transfer)
