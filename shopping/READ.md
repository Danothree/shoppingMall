#domain
1. item
2. member
3. order
4. cart
5. delivery
6. category
#domain attribute
###item
* itemId 
* name
* price
* count
* itemStatus (soldOut,sale)
###member
* memberId
* name
* address
* phoneNum
* role
* password
###order
* orderId
* member
* items
* totalPrice
* orderStatus (ready,completed)
###cart
* cartId
* member
###delivery
* deliveryId
* member
* address
* deliveryStatus (ready,delivery,completed)
###category
* categoryId
# 요구사항
###item
* 상품 등록  POST /items
* 상품 조회  GET  /items
* 상품 검색  GET  /items/{itemId} 
* 상품 삭제  DELETE  /items/{itemId}
* 상품 수정  PUT  /items/{itemId}
* 상품 별 카테고리 구별 

###member
* 로그인 기능  POST  /login
* 로그아웃 기능  POST  /logOut
* 탈퇴 기능  DELETE  /members/{memberId}
* 개인정보 수정 기능  PUT  /members/{memberId}

###order
* 오더 생성  POST  /orders
* 오더 조회  GET  /orders
* 오더 검색  GET  /orders/{orderId}
* 오더 취소 (배송 전이라면)  DELETE  /orders/{orderId}

###cart
* 장바구니에 아이템을 담을 수 있다  POST  /cart
* 장바구니의 상품을 조회  GET  /cart
* 장바구니의 상품을 검색  GET  /cart/{cartId}
* 장바구니의 상품을 삭제  DELETE  /cart/{cartId}
* 장바구니 상품 수정  PUT  /cart/{cartId}
* 장바구니의 상품을 주문 가능  POST  /cart/orders

###delivery
* 주문이 들어오면 배송 등록  POST  /delivery
* 배송 취소 (배송 중이라면 취소 불가능)  DELETE  /delivery

###category
* 카테고리 등록  POST  /category
* 카테고리 수정  PUT  /category/{categoryId}
* 카테고리 삭제  DELETE  /category/{categoryId}
* 카테고리 별 조회 가능  GET  /category/{categoryId}
