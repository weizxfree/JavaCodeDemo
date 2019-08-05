---


---

<h1 id="酒店项目机顶盒项目交接文档">酒店项目&amp;&amp;机顶盒项目交接文档</h1>
<p>本文档是介绍酒店项目以及机顶盒项目目前状态，相较于先前版本具体的需求以及改动点，方便后续人员项目维护。</p>

<table>
<thead>
<tr>
<th>版本</th>
<th>作者</th>
<th>日期</th>
</tr>
</thead>
<tbody>
<tr>
<td>V1.0</td>
<td>韦章翔</td>
<td>2019.8.5</td>
</tr>
</tbody>
</table><h1 id="酒店项目（潘多拉盒子）">酒店项目（潘多拉盒子）</h1>
<h2 id="git-地址">git 地址</h2>
<p><a href="http://gitlab-iot.yzs.io/yunmao/A1-device.git">http://gitlab-iot.yzs.io/yunmao/A1-device.git</a></p>
<h2 id="分支说明">分支说明</h2>
<p>含中英文版本的分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/release-v6.5.5-cnen">release-v6.5.5-cnen</a></p>
<p>公寓版本基线分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/develop-v6.6.0-longganghotel">develop-v6.6.0-longganghotel</a></p>
<p>酒店版本基线分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/develop_longganghotel_switchhotel">develop_longganghotel_switchhotel</a></p>
<p>替换过新版本接口的酒店版本分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/hotel_api">hotel_api</a></p>
<p>连接平台酒店版本分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/develop_hotel_linkplantform">develop_hotel_linkplantform</a></p>
<p>适配了A3新机器的分支：<br>
<a href="http://gitlab-iot.yzs.io/yunmao/A1-device/tree/develop_switchhotel_a3">develop_switchhotel_a3</a></p>
<h2 id="简要说明">简要说明</h2>
<ul>
<li>酒店项目目前大的变动在于集成了新的接口，涉及到的接口将近有15个左右，目前已经全线调通。<br>
具体的接口文档可以找<strong>徐志强</strong>进行对接</li>
<li>酒店版本已经将电视的直播点播功能集成进来。</li>
</ul>
<h2 id="小坑记录">小坑记录</h2>
<p>联调过程中注意config配置文件缓存问题。</p>
<h1 id="机顶盒项目">机顶盒项目</h1>
<h2 id="git-地址-1">git 地址</h2>
<p><a href="http://gitlab-iot.yzs.io/AI-CHIP-TECH/AIOS-Pandora.git">http://gitlab-iot.yzs.io/AI-CHIP-TECH/AIOS-Pandora.git</a></p>
<h2 id="分支说明-1">分支说明</h2>
<p>更换了TR地址的分支:<br>
<a href="http://gitlab-iot.yzs.io/AI-CHIP-TECH/AIOS-Pandora/tree/develop_tv_tr">develop_tv_tr</a><br>
主要改动点在于增加了新的客控指令以及将点播直播的播放源切换成联通的CIBN apk</p>
<h2 id="简要说明-1">简要说明</h2>
<p>机顶盒项目增加了多条客控命令，具体指令数据可以和<strong>胡志强</strong>对接，有相应的文档。</p>
<h2 id="小坑记录-1">小坑记录</h2>
<p>因电视项目目前用到系统权限，所以在新板子上，需要系统签名，打包给对方的时候u需要考虑签名问题。</p>

