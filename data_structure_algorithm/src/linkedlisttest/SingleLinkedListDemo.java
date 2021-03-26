package linkedlisttest;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入结点
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        System.out.println("修改前");
        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后");
        singleLinkedList.list();

    }

}

class SingleLinkedList{
    private HeroNode head = new HeroNode(0, "","");

    // 尾部添加结点的方法
    public void addNode(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 第二种添加英雄的方式，根据排名将英雄插入到指定位置
    public void addByOrder(HeroNode heroNode){
        // 头节点不能动，因此需要通过辅助变量（指针），通过遍历来找到需要添加的位置
        HeroNode temp = head;

        boolean flag = false; // flag 标识 添加的编号是否存在，默认为false
        while (true){
            if (temp.next  == null){  // 说明temp已经在链表的最后了，无论咋的都需要break了
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            } else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next; // 后移，遍历当前链表

        }
        if(flag){ // 不能添加，说明编号已经存在
            System.out.println("准备插入的英雄编号已经存在！不能加入了 \n");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点信息
    public void update(HeroNode newHeroNode){
        // 如果头节点指向null，则说明链表为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp =temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("没有找到节点");
        }



    }

     // 遍历链表的方法
    public void list(){
        // 头节点指向第一个链表
        if(head.next == null){
            System.out.println("链表为空");
        }
        // 因为头节点不能动，需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode (int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
