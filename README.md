# RealM / GreenDao benchmark


## Results

RealM version 2.3.0
ObjectBox 0.9.6

Executed on Samsung Galaxy S3. Average on 50 iterations.
Item inserted : 20K
Time in MS. (Lower is better)

|        |  RealM |  ObjectBox |  For loop | Optimised For loop |
|--------|--------|------------|-----------|--------------------|
| Insert |  1530  |     **1227**   |    N/d    |         N/d        |
| Search |     **10 **  |     14     |     18    |          17        |


Executed on Samsung Galaxy S3. Average on 10 iterations.
Item inserted : 50K
Time in MS. (Lower is better)

|        |  RealM |  ObjectBox |  For loop | Optimised For loop |
|--------|--------|------------|-----------|--------------------|
| Insert |  3562  |     **2906 **    |    N/d   |         N/d       |
| Search |     **31 **  |     45     |     49    |          46        |

## Old Results

Executed on Samsung Galaxy S3 with 10 iterations.
RealM version 0.90.1
GreenDao 2.2.0

### Search

![Result](https://github.com/lucas34/realm-benchmark/blob/master/results/search_100k_e.png)
![Result](https://github.com/lucas34/realm-benchmark/blob/master/results/search_100k_luc.png)

## Contributor

* [Lucas Nelaupe](http://www.lucas-nelaupe.fr/) - <https://github.com/lucas34>

## Credits

* [RealM](https://github.com/realm/realm-java/) 
* [GreenDao](https://github.com/greenrobot/greenDAO/) 
* [ObjectBox](http://greenrobot.org/announcement/introducing-objectbox-beta/) 

## License

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
