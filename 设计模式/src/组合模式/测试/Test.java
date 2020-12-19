package 组合模式.测试;

import 组合模式.学校.University;
import 组合模式.学院.College;
import 组合模式.院系.Faculty;

/**
 * @author lxy
 * @date 2020/12/19 14:53
 **/
public class Test {

    public static void main(String[] args) {
        /**应用场景
         * 组合模式->如果需求中需要树形结构
         * 就可以考虑到用组合模式
         * &eg 学校->学院->专业
         * 学校->[{
         *     "学院1":[{
         *         "专业1",
         *         "专业2",
         *         "专业3"
         *     }],
         *     "学院2":[{
         *         "专业1",
         *         "专业2",
         *         "专业3",
         *     }],
         *     "学院3":[{
         *         "专业1",
         *         "专业2",
         *         "专业3",
         *     }]
         * }]
         * */

        /**创建一个学校*/
        final University university = new University("吉林化工学院","世界第一院校");
        /**创建两个学院*/
        final College infoCollege = new College("信息与控制与控制工程学院", "全校最大学院");
        final College mathCollege = new College("理学院", "人数最少的学院");
        /**创建信控学院得专业*/
        final Faculty info = new Faculty("电子信息","还凑合");
        final Faculty computer = new Faculty("计算机专业","一般般的了");
         /**创建两个理学院得专业*/
        final Faculty math = new Faculty("数学","专业搞数学");
        final Faculty phy = new Faculty("物理","学好数理化走遍全天下");

        /**将学院添加到学校里*/
        university.add(infoCollege);
        university.add(mathCollege);
        /**添加信控专业*/
        infoCollege.add(info);
        infoCollege.add(computer);
        /**添加理学院专业*/
        mathCollege.add(math);
        mathCollege.add(phy);
        university.print();
    }

}
