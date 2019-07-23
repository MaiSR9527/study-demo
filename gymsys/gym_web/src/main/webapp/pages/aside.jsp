<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.get("userInfo").userName}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/pages/main.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                <span>器材管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>


            </a>
                <ul class="treeview-menu">

                    <li id="system-setting1"><a
                            href="${pageContext.request.contextPath}/equipment/commonFindAll.do?page=1&size=4"> <i
                            class="fa fa-circle-o"></i> 器材查询
                    </a></li>

                    <li id="system-setting2"><a
                            href="${pageContext.request.contextPath}/equipment/rentFindAll.do?page=1&size=4"> <i
                            class="fa fa-circle-o"></i> 器材租借
                    </a></li>

                    <li id="system-setting3"><a
                            href="${pageContext.request.contextPath}/equipment/findAll.do?page=1&size=4">
                        <i class="fa fa-circle-o"></i> 器材添加 删除 维护
                    </a></li>
                    <li id="system-setting4"><a
                            href="${pageContext.request.contextPath}/equipment/maintainFindAll.do?page=1&size=4">
                        <i class="fa fa-circle-o"></i> 器材维护处理
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>订单管理</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">
                    <li id="system-setting6"><a
                            href="${pageContext.request.contextPath}/order/findAll.do?page=1&size=4">
                        <i class="fa fa-circle-o"></i> 订单查询
                    </a></li>
                    <li id="system-setting7"><a
                            href="${pageContext.request.contextPath}/order/findAllByEquipStatus.do?page=1&size=4">
                        <i class="fa fa-circle-o"></i> 器材回收审核
                    </a></li>
                    <li id="system-setting8"><a
                            href="${pageContext.request.contextPath}/order/findAllByOrderStatus.do?page=1&size=4"> <i
                            class="fa fa-circle-o"></i> 订单租借审核
                    </a></li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>