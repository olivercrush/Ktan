import sys, pygame
import json

size = width, height = 1920, 1080

HEX_WIDTH = 200
HEX_HEIGTH = 200

BLACK = 0, 0, 0
GREY = 128, 128, 128
WHITE = 255, 255, 255
YELLOW = 255, 255, 0
LIGHT_YELLOW = 128, 128, 0
ORANGE = 255, 128, 0
GREEN = 0, 255, 0
LIGHT_GREEN = 0, 128, 0

def visualize(board_json):
    pygame.init()
    screen = pygame.display.set_mode(size)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT: sys.exit()

        screen.fill(BLACK)
        for y in range(len(board_json['hexGrid'])):
            for x in range(len(board_json['hexGrid'][y])):
                draw_hexagone(screen, board_json['hexGrid'][y][x]['hexType'], x, y)

        pygame.display.flip()

def draw_hexagone(surface, type, x, y):
    row_offset = 0
    if y % 2 == 1:
        row_offset = HEX_WIDTH / 2

    center_x = (x + 1) * HEX_WIDTH + row_offset
    center_y = (y + 1) * (HEX_HEIGTH * 3 / 4)

    hex_vertices = (
        (center_x, center_y - HEX_HEIGTH / 2), 
        (center_x - HEX_WIDTH / 2, center_y - HEX_HEIGTH / 4), 
        (center_x - HEX_WIDTH / 2, center_y + HEX_HEIGTH / 4), 
        (center_x, center_y + HEX_HEIGTH / 2), 
        (center_x + HEX_WIDTH / 2, center_y + HEX_HEIGTH / 4), 
        (center_x + HEX_WIDTH / 2, center_y- HEX_HEIGTH / 4)
    )
    pygame.draw.polygon(surface, get_color_from_hex_type(type), hex_vertices)

def get_color_from_hex_type(hex_type):
    if hex_type == "FIELDS":
        return YELLOW
    elif hex_type == "FOREST":
        return GREEN
    elif hex_type == "PASTURE":
        return LIGHT_GREEN
    elif hex_type == "MOUNTAINS":
        return GREY
    elif hex_type == "HILLS":
        return ORANGE
    elif hex_type == "DESERT":
        return LIGHT_YELLOW

    return BLACK


f = open('classicBoard.json')
board_json = json.load(f)

visualize(board_json)