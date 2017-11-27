# RealM / ObjectBox benchmark

## Results

RealM version 4.2.0<br/>
ObjectBox 1.2.1<br/>
GreenDAO 3.2.2<br/>

Item inserted : 20K<br/>
(Lower is better) <br/>

|             |  RealM |  RealM (index) |  ObjectBox |  GreenDAO  |  For loop | Optimised For loop |
|-------------|--------|----------------|------------|------------|-----------|--------------------|
| Insert (ms) |  285   |      355       |      204   |     395    |    N/A    |         N/A        |
| Search (ms) |  3.824 |     0.203      |    4.004   |   25.730   |    3.212  |        2.221       |

## Old Results

Executed on Samsung Galaxy S3. Average on 10 iterations.<br/>
Item inserted : 50K<br/>
Time in MS. (Lower is better)<br/>

|        |  RealM |  ObjectBox |  For loop | Optimised For loop |
|--------|--------|------------|-----------|--------------------|
| Insert |  3562  |     **2906**    |    N/d   |         N/d       |
| Search |     **31**  |     45     |     49    |          46        |



Executed on Samsung Galaxy S3 with 10 iterations.<br/>
RealM version 0.90.1<br/>
GreenDao 2.2.0<br/>

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
