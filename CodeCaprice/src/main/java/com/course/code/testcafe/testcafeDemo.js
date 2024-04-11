// ES6 导包语法
import { Selector } from 'testcafe';


const getData = require('../conf/conf.json')  //读取配置文件
const url = getData.url //读取配置文件中的url
// 声明一个 fixture 测试项目
fixture('这是第一个测试组') //测试方法 test 必须放在测试组声明后面。
  // 打开一个 web 页面用于一组测试
  .page(url)

// 创建一个测试用例
test('第一个测试用例', async t => {  //async 包含测试代码的异步函数;  t 测试用例的测试控制器
  // Test code
  await t // t是我们的测试用例的控制器
  .typeText('#developer-name','guangguang') //typeText 方法用来键入文本，它接受两个参数：第一个参数是 selector 选择器（它的语法类似 jQuery 选择器的语法）；第二个参数是你要键入的文本；
  .click('#submit-button') // click 方法用来模拟鼠标点击，它接受一个参数，是一个 selector 选择器
  .expect(Selector('#article-header').innerText).eql('Thank you, guangguang!')// 添加断言 前面为获取的值 后面为预期结果

});

//创建第二个用例
test.page('https://www.baidu.com/')
    ('Test2',async t => {
        console.log('打开百度成功')
    })

// 定义元数据
fixture
    .meta('fixtureID','f-001')
    .meta({'author':'f-001','date':'0410'})

test
    .meta('testID','t-001')
    ('metaTest',async t =>  {
        console.log('元数据')
    })

test('滚动元素', async t =>{
    const tried = Selector('label').withText('I have tried TestCafe')
    await t
    .scroll(tried,'bottomRight').wait(3000)
})

test('滚动元素到可见视图', async t => {
    const target = Selector('#submit-button');
    await t
    .scrollIntoView(target);
});