<%@ page contentType="text/html;charset=UTF-8" language="java"
         trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>content write</title>

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/contents/css/reset.css">
    <link rel="stylesheet" href="/contents/css/admin.css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/TableDnD/0.9.1/jquery.tablednd.js"
            integrity="sha256-d3rtug+Hg1GZPB7Y/yTcRixO/wlI78+2m08tosoRn7A=" crossorigin="anonymous"></script>
    <script src="/contents/js/admin.js"></script>
</head>
<body>
<div id="wrap" class="page01_01">
    <div class="header">
        <div class="inner">
            <a href="javascript:;">
                <img src="../images/admin/logo.png" alt="아카이브">
            </a>
            <div class="select-wrap">
                <button type="button" class="select-btn">고길동</button>
                <div class="select-list">
                    <a href="javascript:;">비밀번호 변경</a>
                    <a href="javascript:;">로그아웃</a>
                </div>
            </div>
        </div>
        <div class="nav">
            <div class="inner">
                <ul class="nav-list">
                    <li>
                        <a href="javascript:;">콘텐츠 관리</a>
                        <div class="depth2">
                            <ul class="inner">
                                <li>
                                    <a href="javascript:;">단건 관리</a>
                                </li>
                                <li>
                                    <a href="javascript:;">일괄 관리</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;">카테고리 관리</a>
                        <div class="depth2">
                            <ul class="inner">
                                <li>
                                    <a href="javascript:;">카테고리 관리</a>
                                </li>
                                <li>
                                    <a href="javascript:;">내부용 출처 관리</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;">통계 관리</a>
                    </li>
                    <li>
                        <a href="javascript:;">사용자 관리</a>
                    </li>
                    <li>
                        <a href="javascript:;">서비스 관리</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="inner">
            <div class="table-cnt">
                <div class="table-type02">
                    <div class="table-top">
                        <span class="table-tit">자료 정보 등록</span>
                        <div class="btn-wrap">
                            <!-- s: 20221213 삭제 -->
                            <!-- <button type="button" class="btn w90">추가 등록</button> -->
                            <!-- e: 20221213 삭제 -->
                            <button type="button" class="btn w90">초기화</button>
                            <button type="button" class="btn w90">저장</button>
                            <button type="button" class="btn w90">닫기</button>
                        </div>
                    </div>
                    <table>
                        <colgroup>
                            <col width="6%">
                            <col width="9%">
                            <col width="*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th colspan="2">
                    <span>
                      <em>＊</em>콘텐츠 유형
                    </span>
                            </th>
                            <td>
                                <!-- s: 20221130 수정 -->
                                <!-- <input type="radio" id="radio01_1" name="cate" checked>
                                <label for="radio01_1">이미지</label>
                                <input type="radio" id="radio01_2"  name="cate">
                                <label for="radio01_2">아이콘</label>
                                <input type="radio" id="radio01_3" name="cate">
                                <label for="radio01_3">캐릭터</label>
                                <input type="radio" id="radio01_4"  name="cate">
                                <label for="radio01_4">동영상</label> -->
                                <select name="" id="">
                                    <option value="">이미지</option>
                                    <option value="">아이콘</option>
                                    <option value="">캐릭터</option>
                                    <option value="">동영상</option>
                                </select>
                                <!-- e: 20221130 수정 -->
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2">
                    <span>
                      <em>＊</em>유료/무료
                    </span>
                            </th>
                            <td>
                                <input type="radio" id="radio02_1" name="price" value="1" class="radio02_1" checked>
                                <label for="radio02_1">무료</label>

                                <input type="radio" id="radio02_2" name="price" value="2" class="radio02_2">
                                <label for="radio02_2">유료</label>

                                <div class="input-text-wrap">
                                    <input type="text" class="price-txt">
                                    <span>원</span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2">
                    <span>
                      <em>＊</em>노출 여부
                    </span>
                            </th>
                            <td>
                                <input type="radio" id="radio03_1" name="view">
                                <label for="radio03_1">노출</label>
                                <input type="radio" id="radio03_2" name="view" checked>
                                <label for="radio03_2">미노출</label>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2">
                    <span>
                      <em>＊</em>제목
                    </span>
                            </th>
                            <td>
                                <input type="text" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2">
                    <span>
                      <em>＊</em>키워드
                    </span>
                            </th>
                            <td>
                                <input type="text" placeholder="최대 10개 까지 작성 가능합니다. (작성 후 엔터)">
                                <div class="keyword-wrap">
                                    <div class="keyword">
                                        <span>키워드1</span>
                                        <button type="button" class="delete"></button>
                                    </div>
                                    <div class="keyword">
                                        <span>키워드2</span>
                                        <button type="button" class="delete"></button>
                                    </div>
                                    <div class="keyword">
                                        <span>키워드3</span>
                                        <button type="button" class="delete"></button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2">설명</th>
                            <td>
                                <input type="text" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <th rowspan="3" class="bd-r">출처</th>
                            <th>출처 구분</th>
                            <td>
                                <select name="" id="">
                                    <option value="">출처</option>
                                    <option value="">기타</option>
                                </select>
                                <div class="etc">
                                    <input type="text" placeholder="기타 선택 시 작성" maxlength="50">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>외부 출처URL</th>
                            <td>
                                <input type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>내부 관리용 출처</th>
                            <td>
                                <input type="text" class="w255">
                                <button type="button" class="btn pop-btn" data-pop="search-pop">검색</button>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="2" rowspan="2">카테고리 선택</th>
                            <td>
                                <select name="" id="">
                                    <option value="">-구분-</option>
                                    <option value="">공통</option>
                                </select>
                                <select name="" id="">
                                    <option value="">-</option>
                                </select>
                                <button type="button" class="btn add-btn">추가</button>
                            </td>
                        </tr>
                        <tr>
                            <td class="blank"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-type02">
                    <div class="table-top">
                        <span class="table-tit">파일 등록</span>
                    </div>
                    <table>
                        <colgroup>
                            <col width="15%">
                            <col width="*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>썸네일 파일</th>
                            <td>
                                <div class="txt-box">
                                    <span></span>
                                    <button type="button" class="btn del-btn">삭제</button>
                                </div>
                                <div class="upload">
                                    <span>파일을 드래그 앤 드롭하여 업로드해주세요.</span>
                                    <button type="button" class="btn">파일 선택</button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>
                    <span>
                      <em>＊</em>원본 파일
                    </span>
                            </th>
                            <td>
                                <div class="txt-box">
                                    <span></span>
                                    <button type="button" class="btn del-btn">삭제</button>
                                        <!-- 미리보기 버튼 -->
                                        <button type="button" class="btn preview-btn">미리보기</button>
                                </div>
                                <div class="upload">
                                    <span>파일을 드래그 앤 드롭하여 업로드해주세요.</span>
                                    <button type="button" class="btn">파일 선택</button>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="dim"></div>
    <div class="popup search-popup" data-pop="search-pop">
        <div class="view-cnt">
            <div class="tit">
                <span>내부용 출처 검색</span>
                <div class="btn-wrap">
                    <button type="button" class="pop-close"></button>
                </div>
            </div>
            <div class="cnt">
                <div class="search-wrap">
                    <input type="text" maxlength="30">
                    <button class="btn">검색</button>
                </div>
                <ul>
                    <li class="title">내부용 출처명</li>
                    <li>
                        <button type="button" class="name pop-close">똑똑한 하루 도형 3단계</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">검정교과서 사회(김정인) 4학년 2학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">T셀파 수업연구소 클립아트 교과서삽화</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">검정교과서 사회(박용조) 4학년 2학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">유튜브 가리봉특파원</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">유튜브 밀크티타임</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">검정교과서 과학(이상원) 4학년 1학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">검정교과서 수학(한대희) 3하년 1학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">똑똑한 하루 사회 5학년 1학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">똑똑한 하루 사회 5학년 2학기</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">똑똑한 하루 한자 C단계</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">사진영상자료실</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">T셀파 쉬는 시간 사회랑 역사랑</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">T셀파 쉬는 시간 안전한 생활</button>
                    </li>
                    <li>
                        <button type="button" class="name pop-close">똑똑한 하루 한자 B단계</button>
                    </li>
                </ul>
                <div class="paging-wrap">
                    <a href="javascript:;" class="first"></a>
                    <a href="javascript:;" class="prev"></a>
                    <a href="javascript:;" class="page active">
                        <span>1</span>
                    </a>
                    <a href="javascript:;" class="page">
                        <span>2</span>
                    </a>
                    <a href="javascript:;" class="page">
                        <span>3</span>
                    </a>
                    <a href="javascript:;" class="page">
                        <span>4</span>
                    </a>
                    <a href="javascript:;" class="page">
                        <span>5</span>
                    </a>
                    <a href="javascript:;" class="next"></a>
                    <a href="javascript:;" class="last"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    // input show
    $('input[type="radio"]').on('click', function () {
        let _this = $(this);
        if (_this.hasClass('radio02_2')) {
            _this.parent('td').find('.input-text-wrap').css('display', 'inline-block');
        } else if (_this.hasClass('radio02_1')) {
            _this.parent('td').find('.input-text-wrap').css('display', 'none');
        }
    })
</script>
</html>
