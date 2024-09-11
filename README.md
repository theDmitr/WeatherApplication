# WeatherApplication
API for storing and retrieving weather.

## EndPoints

+ ``HTTP GET /weatherPart`` - the endpoint for obtaining weather data for a specified period and location.<br>
Takes next arguments:

|    Key     |         Data type          | Mandatory |  Example   |
|:----------:|:--------------------------:|:---------:|:----------:|
| dateFirst  | Date (YYYY-MM-DD hh:mm:ss) |     +     | 2024-09-12 |
| dateSecond | Date (YYYY-MM-DD hh:mm:ss) |     -     | 2024-09-13 |
|  location  |           String           |     +     | "Kostroma" |

+ ``HTTP POST /weatherPart`` - the endpoint for storing weather data for a specified period and location.<br>
  Takes next arguments:

|      Key      |         Data type          | Mandatory |  Example   |
|:-------------:|:--------------------------:|:---------:|:----------:|
|   dateTime    | Date (YYYY-MM-DD hh:mm:ss) |     +     | 2024-09-12 |
|  temperature  |           Float            |     -     |     15     |
|   windSpeed   |           Float            |     -     |     3      |
| windDirection |   Integer, String (enum)   |     -     |     2      |
|   pressure    |           Float            |     -     |     2      |
|  weatherType  |   Integer, String (enum)   |     -     |     4      |
|   location    |           String           |     +     | "Kostroma" |

## Enums
+ WindDirection - ``NORTH, SOUTH, EAST, WEST, NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST``
+ WeatherType - ``SUNNY, RAIN, THUNDERSTORM, CLOUDY, PARTLY_CLOUDY``